package algo.trading.common.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * DTO class for holding the backtest results of a trading strategy. Contains performance
 * statistics, risk management, and other key metrics.
 */
@Data
@Builder
public class BackTestStrategyStatsReportDto {
  // Identifiers for the strategy and market
  private String instrument; // Instrument ticker
  private String timeframe; // Timeframe (e.g., 1h, 5m)
  private BigDecimal stopLossCoefficient; // Stop loss coefficient
  private BigDecimal takeProfitCoefficient; // Take profit coefficient
  private long fromTimestamp; // Start of the test period
  private long toTimestamp; // End of the test period

  // === Profitability ===

  private BigDecimal totalBalance; // Total result of the strategy in currency
  private BigDecimal averageTradeProfit; // Average profit per trade
  private BigDecimal maxProfitTrade; // Max profit from a single trade
  private BigDecimal maxLossTrade; // Max loss from a single trade
  private int totalTrades; // Total number of trades

  // === Win and Loss Metrics ===

  private int wins; // Number of profitable trades
  private int losses; // Number of losing trades
  private BigDecimal winRate; // Win rate percentage
  private BigDecimal lossRate; // Loss rate percentage

  // === Risk Management and Stability ===

  private BigDecimal maxDrawdown; // Maximum drawdown
  private BigDecimal equityPeak; // Peak equity
  private BigDecimal stdDev; // Standard deviation of trade profits
  private BigDecimal sharpeRatio; // Sharpe ratio (risk-adjusted return)

  // === Expectancy and Efficiency ===

  private BigDecimal expectancy; // Expected profit per trade
  private BigDecimal profitFactor; // Profit factor (total profit / total loss)
  private BigDecimal averageWin; // Average profit for winning trades
  private BigDecimal averageLoss; // Average loss for losing trades

  // === History of Equity and Profit ===

  private List<BigDecimal> tradeProfits; // List of trade profits
  private List<BigDecimal> equityCurve; // Equity curve history

  /**
   * Builds a comprehensive report based on the backtest data of trades.
   *
   * @param tradeDeals List of trade profits/losses
   * @param instrument Instrument ticker
   * @param timeframe Timeframe (in seconds, e.g., 3600 for 1 hour)
   * @param stopLossCoefficient Stop loss coefficient
   * @param takeProfitCoefficient Take profit coefficient
   * @param fromTimestamp Start of the test period (Epoch time)
   * @param toTimestamp End of the test period (Epoch time)
   * @return A BackTestStrategyStatsReport object with complete stats
   */
  public static BackTestStrategyStatsReportDto buildStatsReport(
      List<BigDecimal> tradeDeals,
      String instrument,
      String timeframe,
      BigDecimal stopLossCoefficient,
      BigDecimal takeProfitCoefficient,
      long fromTimestamp,
      long toTimestamp) {
    int wins = 0;
    int losses = 0;
    BigDecimal totalProfit = BigDecimal.ZERO;
    BigDecimal equity = BigDecimal.ZERO;
    BigDecimal equityPeak = BigDecimal.ZERO;
    BigDecimal maxDrawdown = BigDecimal.ZERO;
    BigDecimal maxProfit = new BigDecimal("-1e10");
    BigDecimal maxLoss = new BigDecimal("1e10");

    List<BigDecimal> equityCurve = new ArrayList<>();
    List<BigDecimal> winsList = new ArrayList<>();
    List<BigDecimal> lossesList = new ArrayList<>();

    for (BigDecimal profit : tradeDeals) {
      totalProfit = totalProfit.add(profit);
      equity = equity.add(profit);
      equityPeak = equity.max(equityPeak);
      maxDrawdown = maxDrawdown.max(equityPeak.subtract(equity));
      maxProfit = maxProfit.max(profit);
      maxLoss = maxLoss.min(profit);
      equityCurve.add(equity);

      if (profit.compareTo(BigDecimal.ZERO) > 0) {
        wins++;
        winsList.add(profit);
      } else if (profit.compareTo(BigDecimal.ZERO) < 0) {
        losses++;
        lossesList.add(profit);
      }
    }

    int totalTrades = tradeDeals.size();
    BigDecimal averageWin = wins > 0 ? avg(winsList) : BigDecimal.ZERO;
    BigDecimal averageLoss = losses > 0 ? avg(lossesList) : BigDecimal.ZERO;
    BigDecimal profitFactor = calculateProfitFactor(winsList, lossesList);

    BigDecimal winRate =
        totalTrades > 0
            ? BigDecimal.valueOf(wins)
                .divide(BigDecimal.valueOf(totalTrades), 4, RoundingMode.HALF_UP)
            : BigDecimal.ZERO;
    BigDecimal lossRate =
        totalTrades > 0
            ? BigDecimal.valueOf(losses)
                .divide(BigDecimal.valueOf(totalTrades), 4, RoundingMode.HALF_UP)
            : BigDecimal.ZERO;

    BigDecimal expectancy = winRate.multiply(averageWin).add(lossRate.multiply(averageLoss));

    return BackTestStrategyStatsReportDto.builder()
        .instrument(instrument)
        .timeframe(timeframe)
        .stopLossCoefficient(stopLossCoefficient)
        .takeProfitCoefficient(takeProfitCoefficient)
        .fromTimestamp(fromTimestamp)
        .toTimestamp(toTimestamp)
        .totalBalance(totalProfit)
        .averageTradeProfit(
            totalTrades > 0
                ? totalProfit.divide(BigDecimal.valueOf(totalTrades), 4, RoundingMode.HALF_UP)
                : BigDecimal.ZERO)
        .maxProfitTrade(maxProfit)
        .maxLossTrade(maxLoss)
        .totalTrades(totalTrades)
        .wins(wins)
        .losses(losses)
        .winRate(winRate)
        .lossRate(lossRate)
        .maxDrawdown(maxDrawdown)
        .equityPeak(equityPeak)
        .stdDev(stdDev(tradeDeals))
        .sharpeRatio(sharpeRatio(tradeDeals)) // пока условный, можно уточнить позже
        .expectancy(expectancy)
        .profitFactor(profitFactor)
        .averageWin(averageWin)
        .averageLoss(averageLoss)
        .tradeProfits(tradeDeals)
        .equityCurve(equityCurve)
        .build();
  }

  private static BigDecimal calculateProfitFactor(
      List<BigDecimal> winsList, List<BigDecimal> lossesList) {
    BigDecimal allProfit = sum(winsList);
    BigDecimal allLoss = sum(lossesList).abs();

    if (allLoss.compareTo(BigDecimal.ZERO) > 0) {
      return allProfit.divide(allLoss, 4, RoundingMode.HALF_UP);
    } else if (allProfit.compareTo(BigDecimal.ZERO) > 0) {
      return new BigDecimal("1e10");
    } else {
      return BigDecimal.ZERO;
    }
  }

  private static BigDecimal avg(List<BigDecimal> list) {
    return list.isEmpty()
        ? BigDecimal.ZERO
        : sum(list).divide(BigDecimal.valueOf(list.size()), 4, RoundingMode.HALF_UP);
  }

  private static BigDecimal sum(List<BigDecimal> list) {
    return list.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  private static BigDecimal stdDev(List<BigDecimal> list) {
    if (list.isEmpty()) {
      return BigDecimal.ZERO;
    }
    BigDecimal mean = avg(list);
    BigDecimal variance =
        list.stream()
            .map(p -> p.subtract(mean).pow(2))
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .divide(BigDecimal.valueOf(list.size()), 4, RoundingMode.HALF_UP);
    return BigDecimal.valueOf(Math.sqrt(variance.doubleValue()));
  }

  private static BigDecimal sharpeRatio(List<BigDecimal> list) {
    BigDecimal mean = avg(list);
    BigDecimal std = stdDev(list);
    return std.compareTo(BigDecimal.ZERO) > 0
        ? mean.divide(std, 4, RoundingMode.HALF_UP)
        : BigDecimal.ZERO;
  }

  @Override
  public String toString() {
    Timeframe tf = Timeframe.fromSeconds(Integer.parseInt(timeframe));
    String tfDisplay = tf.getDisplayName();

    String fromDateStr =
        Instant.ofEpochSecond(fromTimestamp)
            .atZone(ZoneOffset.UTC)
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    String toDateStr =
        Instant.ofEpochSecond(toTimestamp)
            .atZone(ZoneOffset.UTC)
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    return String.format(
        "\n=== Backtest Report [%s | %s] ===\n"
            + "Period: %s → %s\n"
            + "Stop Loss Coefficient: %.2f\n"
            + "Take Profit Coefficient: %.2f\n"
            + "\n--- Performance ---\n"
            + "Total Balance:         %s\n"
            + "Avg Trade Profit:      %s\n"
            + "Max Profit Trade:      %s\n"
            + "Max Loss Trade:        %s\n"
            + "\n--- Trades ---\n"
            + "Total Trades:          %d\n"
            + "Wins / Losses:         %d / %d\n"
            + "Win Rate:              %s%%\n"
            + "Loss Rate:             %s%%\n"
            + "\n--- Risk & Stability ---\n"
            + "Max Drawdown:          %s\n"
            + "Equity Peak:           %s\n"
            + "Std Dev:               %s\n"
            + "Sharpe Ratio:          %s\n"
            + "\n--- Expectancy & Efficiency ---\n"
            + "Expectancy:            %s\n"
            + "Profit Factor:         %s\n"
            + "Avg Win / Avg Loss:    %s / %s\n",
        instrument,
        tfDisplay,
        fromDateStr,
        toDateStr,
        stopLossCoefficient,
        takeProfitCoefficient,
        format(totalBalance),
        format(averageTradeProfit),
        format(maxProfitTrade),
        format(maxLossTrade),
        totalTrades,
        wins,
        losses,
        formatPercent(winRate),
        formatPercent(lossRate),
        format(maxDrawdown),
        format(equityPeak),
        format(stdDev),
        format(sharpeRatio),
        format(expectancy),
        format(profitFactor),
        format(averageWin),
        format(averageLoss));
  }

  private String format(BigDecimal value) {
    return value != null ? value.setScale(2, RoundingMode.HALF_UP).toPlainString() : "n/a";
  }

  private String formatPercent(BigDecimal value) {
    return value != null
        ? value.multiply(BigDecimal.valueOf(100)).setScale(2, RoundingMode.HALF_UP).toPlainString()
        : "n/a";
  }
}
