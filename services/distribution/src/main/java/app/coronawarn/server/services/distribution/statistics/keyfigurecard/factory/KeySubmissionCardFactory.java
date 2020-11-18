package app.coronawarn.server.services.distribution.statistics.keyfigurecard.factory;

import app.coronawarn.server.common.protocols.internal.stats.KeyFigure;
import app.coronawarn.server.common.protocols.internal.stats.KeyFigure.Rank;
import app.coronawarn.server.common.protocols.internal.stats.KeyFigure.Trend;
import app.coronawarn.server.common.protocols.internal.stats.KeyFigure.TrendSemantic;
import app.coronawarn.server.common.protocols.internal.stats.KeyFigureCard;
import app.coronawarn.server.common.protocols.internal.stats.KeyFigureCard.Builder;
import app.coronawarn.server.services.distribution.statistics.StatisticsJsonStringObject;
import app.coronawarn.server.services.distribution.statistics.keyfigurecard.KeyFigureCardSequenceConstants;
import app.coronawarn.server.services.distribution.statistics.keyfigurecard.factory.HeaderCardFactory;
import java.util.List;

public class KeySubmissionCardFactory extends HeaderCardFactory {

  @Override
  protected Integer getCardId() {
    return KeyFigureCardSequenceConstants.KEY_SUBMISSION_CARD_ID;
  }

  @Override
  protected KeyFigureCard buildKeyFigureCard(StatisticsJsonStringObject stats, Builder keyFigureBuilder) {
    return keyFigureBuilder.addAllKeyFigures(
        List.of(
          KeyFigure.newBuilder()
              .setValue(stats.getPersonsWhoSharedKeysDaily())
              .setRank(Rank.PRIMARY)
              .setDecimals(0)
              .setTrend(Trend.UNSPECIFIED_TREND)
              .setTrendSemantic(TrendSemantic.UNSPECIFIED_TREND_SEMANTIC)
              .build(),
          KeyFigure.newBuilder()
              .setValue(stats.getPersonsWhoSharedKeys7daysSum())
              .setRank(Rank.SECONDARY)
              .setDecimals(0)
              .setTrend(Trend.INCREASING)
              .setTrendSemantic(TrendSemantic.NEGATIVE)
              .build(),
          KeyFigure.newBuilder()
              .setValue(stats.getPersonsWhoSharedKeysCumulated())
              .setRank(Rank.TERTIARY)
              .setDecimals(0)
              .setTrend(Trend.UNSPECIFIED_TREND)
              .setTrendSemantic(TrendSemantic.UNSPECIFIED_TREND_SEMANTIC)
              .build()))
        .build();
  }
}