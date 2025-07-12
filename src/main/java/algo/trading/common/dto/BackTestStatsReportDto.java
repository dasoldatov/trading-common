package algo.trading.common.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Minimal and practical DTO for analyzing a trading strategy's backtest performance. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BackTestStatsReportDto {

  /** Net profit/loss from all trades combined. */
  private BigDecimal totalBalance;

  /** Total number of executed trades. */
  private int totalTrades;

  /** Profit factor = total profit / total loss. */
  private BigDecimal profitFactor;

  /** Average profit or loss per trade. */
  private BigDecimal averageTradeProfit;

  /** Win rate = wins / total trades. */
  private BigDecimal winRate;

  /** Worst single trade loss. */
  private BigDecimal maxLossTrade;

  /** Maximum drawdown from peak to trough in equity curve. */
  private BigDecimal maxDrawdown;

  /** Sharpe ratio = average return / stdDev. */
  private BigDecimal sharpeRatio;

  /** Average interest per month. */
  private BigDecimal averageInterestPerMonth;

  /** Intital drawdown in interests. */
  private BigDecimal initialDrawdownInterest;
}
