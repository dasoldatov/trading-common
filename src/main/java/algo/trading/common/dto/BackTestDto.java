package algo.trading.common.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Data;

/**
 * Data Transfer Object for a BackTest configuration. Contains the strategy name, selected
 * instruments, exchange, timeframes, date range, and strategy parameters.
 */
@Data
@Builder
public class BackTestDto {
  private Long id; // Unique identifier for the backtest configuration
  private String strategyName; // The name of the trading strategy used in the backtest
  private List<InstrumentSymbol> symbols; // List of instruments involved in the backtest
  private Exchange exchange; // The exchange where the backtest will take place
  private List<Timeframe> timeframes; // Timeframes used for the backtest
  private LocalDate from; // Start date of the backtest period
  private LocalDate to; // End date of the backtest period
  private Map<BackTestStrategyParams, String> params; // Strategy parameters for the backtest
}
