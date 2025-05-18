package algo.trading.common.dto;

import java.math.BigDecimal;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for a BackTest report. Contains the details of the backtest, including the
 * request, parameters, and strategy statistics.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BackTestReportDto {
  /** Unique backtest identifier. */
  private Long id;

  /** Name of the backtest strategy. */
  private StrategyName strategyName;

  /** Instrument used in the backtest. */
  private InstrumentDto instrument;

  /** Timeframe for the backtest. */
  private Timeframe timeframe;

  /** Duration of the backtest in months. */
  private Integer periodInMonths;

  /** Stats report for the backtest. */
  private BackTestStatsReportDto backTestStats;

  /** The parameters used in backtest processing. */
  private Map<BackTestParams, BigDecimal> params;
}
