package com.rasa.computerman.WebService.Medias;

import com.rasa.computerman.WebService.Medias.New.New;
import com.rasa.computerman.WebService.Medias.New.iNew;
import com.rasa.computerman.WebService.Medias.SuggestBakh.SuggestBakh;
import com.rasa.computerman.WebService.Medias.SuggestBakh.iSuggestBakh;

public interface iMedias {

    SuggestBakh suggestBakh();
    SuggestBakh suggestBakh(iSuggestBakh.iResult iResult);

    New news();
    New news(iNew.iResult iResult);
}
