package algo.trading.common.dto;

/** Strategy event type. */
public enum EventType {
  /** Just tick, no action taken. */
  TICK,
  /** Taken some action. */
  ACTION,
  /** Some error occurred. */
  ERROR
}
