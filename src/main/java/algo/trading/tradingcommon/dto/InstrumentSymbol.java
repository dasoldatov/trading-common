package algo.trading.tradingcommon.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum representing different financial instruments and their properties. Each instrument has a
 * name, symbol, tick size, and tick value.
 */
@Getter
@AllArgsConstructor
public enum InstrumentSymbol {
  SBER("Сбербанк", "SBER", new BigDecimal("0.01"), new BigDecimal("0.1")),
  GAZP("Газпром", "GAZP", new BigDecimal("0.01"), new BigDecimal("0.1")),
  TATN("Татнефть", "TATN", new BigDecimal("0.1"), new BigDecimal("0.1")),
  MTLR("Мечел", "MTLR", new BigDecimal("0.01"), new BigDecimal("0.01")),
  VTBR("ВТБ", "VTBR", new BigDecimal("0.01"), new BigDecimal("0.01")),
  NVTK("Новатек", "NVTK", new BigDecimal("0.2"), new BigDecimal("0.2")),
  CHMF("Северсталь", "CHMF", new BigDecimal("0.2"), new BigDecimal("0.2")),
  RTKM("Ростелеком", "RTKM", new BigDecimal("0.01"), new BigDecimal("0.1")),
  X5("Пятерочка", "X5", new BigDecimal("0.5"), new BigDecimal("0.5")),
  T("Тинькофф", "T", new BigDecimal("0.2"), new BigDecimal("0.2"));

  private final String name;
  private final String symbol;
  private final BigDecimal tickSize;
  private final BigDecimal tickValue;

  /**
   * Retrieves the instrument enum from the symbol string.
   *
   * @param symbol the symbol of the instrument
   * @return the corresponding InstrumentSymbolDto
   * @throws IllegalArgumentException if the symbol is unknown
   */
  public static InstrumentSymbol fromSymbol(String symbol) {
    try {
      return InstrumentSymbol.valueOf(symbol.toUpperCase());
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Unknown symbol: " + symbol, e);
    }
  }
}
