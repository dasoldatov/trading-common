package algo.trading.common.dto;

/**
 * Enum representing the parameters used in a backtest strategy. Defines various parameters related
 * to stop loss, take profit, and commission rate.
 */
public enum BackTestStrategyParams {
  STOP_LOSS_DEVIATION_FROM, // The minimum deviation for stop loss
  STOP_LOSS_DEVIATION_TO, // The maximum deviation for stop loss
  STOP_LOSS_DEVIATION_STEP, // The step size for stop loss deviation
  TAKE_PROFIT_DEVIATION_FROM, // The minimum deviation for take profit
  TAKE_PROFIT_DEVIATION_TO, // The maximum deviation for take profit
  TAKE_PROFIT_DEVIATION_STEP, // The step size for take profit deviation
  COMMISSION_RATE // The commission rate for trades
}
