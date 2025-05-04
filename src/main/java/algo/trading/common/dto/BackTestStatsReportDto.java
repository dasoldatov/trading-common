package algo.trading.common.dto;

import java.math.BigDecimal;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/** Minimal and practical DTO for analyzing a trading strategy's backtest performance. */
@Data
@Builder
public class BackTestStatsReportDto {

  // === Core Performance ===

  /** Net profit/loss from all trades combined. */
  private BigDecimal totalBalance;

  /** Average profit or loss per trade. */
  private BigDecimal averageTradeProfit;

  /** Highest single trade profit. */
  private BigDecimal maxProfitTrade;

  /** Worst single trade loss. */
  private BigDecimal maxLossTrade;

  /** Total number of executed trades. */
  private int totalTrades;

  // === Trade Outcome Breakdown ===

  /** Number of winning trades. */
  private int wins;

  /** Number of losing trades. */
  private int losses;

  /** Win rate = wins / total trades. */
  private BigDecimal winRate;

  // === Risk & Stability ===

  /** Maximum drawdown from peak to trough in equity curve. */
  private BigDecimal maxDrawdown;

  /** Highest equity achieved during backtest. */
  private BigDecimal equityPeak;

  /** Standard deviation of trade results (volatility indicator). */
  private BigDecimal stdDev;

  /** Sharpe ratio = average return / stdDev. */
  private BigDecimal sharpeRatio;

  // === Strategy Efficiency ===

  /** Profit factor = total profit / total loss. */
  private BigDecimal profitFactor;

  /** Average profit on winning trades. */
  private BigDecimal averageWin;

  /** Average loss on losing trades. */
  private BigDecimal averageLoss;

  /** Recovery factor = total profit / max drawdown. */
  private BigDecimal recoveryFactor;

  // === Historical Data (Optional, for visualization) ===

  /** Raw list of trade profits/losses. */
  private List<BigDecimal> tradeProfits;

  /** Cumulative equity curve over time. */
  private List<BigDecimal> equityCurve;
}
