package algo.trading.common.dto;

/**
 * Enum representing all parameters used in a backtest strategy, including value ranges for
 * optimization and fixed coefficients used in execution. This enum is used for both configuration
 * and runtime usage.
 */
public enum BackTestParams {

  /** The starting value (lower bound) of stop-loss deviation for parameter sweep. */
  STOP_LOSS_DEVIATION_FROM,

  /** The ending value (upper bound) of stop-loss deviation for parameter sweep. */
  STOP_LOSS_DEVIATION_TO,

  /** The step size used to increment stop-loss deviation during parameter sweep. */
  STOP_LOSS_DEVIATION_STEP,

  /** The starting value (lower bound) of take-profit deviation for parameter sweep. */
  TAKE_PROFIT_DEVIATION_FROM,

  /** The ending value (upper bound) of take-profit deviation for parameter sweep. */
  TAKE_PROFIT_DEVIATION_TO,

  /** The step size used to increment take-profit deviation during parameter sweep. */
  TAKE_PROFIT_DEVIATION_STEP,

  /** The fixed coefficient used for take-profit calculation during backtest execution. */
  TAKE_PROFIT_COEFFICIENT,

  /** The fixed coefficient used for stop-loss calculation during backtest execution. */
  STOP_LOSS_COEFFICIENT,

  /** The fixed commission rate applied to each trade during the backtest. */
  COMMISSION_RATE
}
