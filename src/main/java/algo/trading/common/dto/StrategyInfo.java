package algo.trading.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** DTO represent info of strategy. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StrategyInfo {
  private String chatId;
  private String symbol;
  private Exchange exchange;
  private Timeframe timeframe;
}
