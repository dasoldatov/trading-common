package algo.trading.common.dto;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** DTO for strategy event. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StrategyEvent {
  private Long strategyId;
  private Instant time;
  private EventType type;
  private String message;
  private MarketOrder order;
  private StrategyState state;
}
