package algo.trading.tradingcommon.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

/**
 * Represents the processing parameters for a backtest, including stop loss, take profit, and
 * commission rate.
 */
@Data
@Builder
public class BackTestProcessingParams {
  private BigDecimal stopLossCoefficient; // The stop loss coefficient for the backtest.
  private BigDecimal takeProfitCoefficient; // The take profit coefficient for the backtest.
  private BigDecimal commissionRate; // The commission rate applied during the backtest.
}
