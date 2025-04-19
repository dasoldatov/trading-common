package algo.trading.tradingcommon.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Data Transfer Object for a BackTest report. Contains the details of the backtest, including the
 * request, parameters, and strategy statistics.
 */
@Data
@Builder
public class BackTestReportDto {

  private Long id; // Unique identifier for the report
  private String name; // Name of the backtest report
  private BackTestProcessingParams params; // The parameters used in backtest processing
  private BackTestStrategyStatsReportDto
      strategyStats; // Strategy statistics report for the backtest
}
