package algo.trading.common.dto;

/** Strategy states. */
public enum StrategyState {
  /** Created, not started. */
  PENDING,
  /** Working. */
  WORKING,
  /** Interrupted(by error reason or thread interrupted). */
  INTERRUPTED,
  /** Cancelled by user. */
  CANCELED,
  /** Fatal error. Manual investigation required. */
  ERROR,
  /** Error, but recoverable. */
  UNKNOWN
}
