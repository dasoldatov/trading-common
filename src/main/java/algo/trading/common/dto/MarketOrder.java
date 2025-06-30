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
  private TradeDto openTrade;
  private String stopLossId;
  private String takeProfitId;
  private TradeDto closeTrade;
  private String orderSide;
  private BigDecimal stopLoss;
  private BigDecimal takeProfit;
  private BigDecimal result;
}
