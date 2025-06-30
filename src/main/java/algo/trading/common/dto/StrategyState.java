package algo.trading.common.dto;

import static algo.trading.common.dto.EventType.ACTION;
import static algo.trading.common.dto.EventType.ERROR;

import lombok.Getter;

/** Strategy states. */
@Getter
public enum StrategyState {
  /** Created, not started. */
  PENDING(ACTION),
  /** Rejected by startup check. */
  REJECTED(ERROR),
  /** Recovery after interrupt. */
  RECOVERY(ACTION),
  /** Working. No open position. */
  WORKING(ACTION),
  /** Working. With open position. */
  OPEN(ACTION),
  /** Working. Stop orders creating error. */
  OPEN_ERROR(ERROR),
  /** Working. Close position error. */
  CLOSE_ERROR(ERROR),
  /** Interrupted(by user or thread interrupted). */
  INTERRUPTED(ERROR),
  /** Cancelled by user. All position is closed. */
  CANCELED(ERROR),
  /** Cancelled by user. Position closing with errors. */
  CANCELLED_ERROR(ERROR),
  /** Error. Manual investigation required. */
  UNKNOWN(ERROR);

  private final EventType eventType;

  StrategyState(EventType eventType) {
    this.eventType = eventType;
  }
}
