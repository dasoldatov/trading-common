package algo.trading.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum representing different timeframes for trading. Each timeframe has a corresponding duration
 * in seconds and a display name.
 */
@Getter
@AllArgsConstructor
public enum Timeframe {
  M1(60, "1 мин"),
  M5(300, "5 мин"),
  M15(900, "15 мин"),
  M30(1800, "30 мин"),
  H1(3600, "1 час"),
  H4(14400, "4 часа"),
  D1(86400, "1 день");

  private final int seconds;
  private final String displayName;

  /**
   * Converts seconds to the corresponding timeframe.
   *
   * @param seconds the duration in seconds
   * @return the corresponding TimeframeDto
   * @throws IllegalArgumentException if no matching timeframe is found
   */
  public static Timeframe fromSeconds(int seconds) {
    for (Timeframe tf : Timeframe.values()) {
      if (tf.seconds == seconds) {
        return tf;
      }
    }
    throw new IllegalArgumentException("Unknown timeframe for seconds: " + seconds);
  }
}
