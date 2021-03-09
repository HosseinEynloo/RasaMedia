package com.rasa.computerman.WebService.Medias;

import com.rasa.computerman.WebService.Medias.New.New;
import com.rasa.computerman.WebService.Medias.New.iNew;
import com.rasa.computerman.WebService.Medias.SuggestBakh.SuggestBakh;
import com.rasa.computerman.WebService.Medias.SuggestBakh.iSuggestBakh;

public class Medias implements iMedias {
    @Override
    public SuggestBakh suggestBakh() {
        return new SuggestBakh();
    }

    @Override
    public SuggestBakh suggestBakh(iSuggestBakh.iResult iResult) {
        return new SuggestBakh(iResult);
    }

    @Override
    public New news() {
        return new New();
    }

    @Override
    public New news(iNew.iResult iResult) {
        return new New(iResult );
    }
}
