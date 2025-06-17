package algo.trading.common.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** DTO represent a market order. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketOrder {
  private String guid;
  private Long strategyId;
  private String groupId;
  private String marketOrderId;
  private String stopLossId;
  private String takeProfitId;
  private String orderSide;
  private BigDecimal price;
  private BigDecimal stopLoss;
  private BigDecimal takeProfit;
  private BigDecimal result;
  private OrderState state;
}
