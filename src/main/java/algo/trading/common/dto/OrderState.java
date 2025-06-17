package algo.trading.common.dto;

/** Order state. */
public enum OrderState {
  /** Prepared. */
  PREPARED,
  /** Filled marked order. */
  OPEN,
  /** StopLoss and TakeProfit created and grouped. */
  CREATED,
  /** Filled. */
  FILLED,
  /** Some error occurred. */
  ERROR
}
