package com.rct.app.modules.quote.service;

import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.quote.dao.QuoteResponseDao;
import com.rct.app.modules.quote.model.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class QuoteService {
    private final QuoteResponseDao quoteResponseDao;

    @Autowired
    public QuoteService(QuoteResponseDao quoteResponseDao) {
        this.quoteResponseDao = quoteResponseDao;
    }

    public Boolean createQuote(Quote quote){
        UUID id = UUID.randomUUID();
        return quoteResponseDao.insertQuote(id,quote);
    }

    public List<Quote> getAllQuote(){
        return quoteResponseDao.selectAllQuote();
    }

    public List<Quote> getAllQuoteByUser(UUID id){
        return quoteResponseDao.selectAllQuoteByUser(id);
    }

    public Optional<Quote> getQuoteById(UUID id){
        return quoteResponseDao.selectQuoteById(id);
    }

    public Boolean deleteQuoteById(UUID id){
        return quoteResponseDao.deleteQuoteById(id);
    }

    public Boolean updateQuoteById(UUID id, Quote quote){
        return quoteResponseDao.updateQuoteById(id,quote);
    }

    public Boolean activateOrDisableQuote(UUID id, ToggleState toggleState){
        return quoteResponseDao.activateOrDisableQuote(id,toggleState);
    }

}
