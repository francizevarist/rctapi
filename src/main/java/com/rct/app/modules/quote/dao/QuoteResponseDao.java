package com.rct.app.modules.quote.dao;

import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.quote.model.Quote;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QuoteResponseDao {
    Boolean insertQuote(UUID id, Quote quote);

    List<Quote> selectAllQuote();

    List<Quote> selectAllQuoteByUser(UUID id);

    Optional<Quote> selectQuoteById(UUID id);

    Boolean deleteQuoteById(UUID id);

    Boolean updateQuoteById(UUID id, Quote quote);

    Boolean activateOrDisableQuote(UUID id, ToggleState toggleState);
}
