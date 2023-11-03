package lotto.service;

import lotto.Lotto;
import lotto.LottoPublisher;

import java.util.List;

public class LottoService {


    public LottoService() {
    }

    public List<Lotto> purchaseLotto(Long purchaseAmount) {
        LottoPublisher lottoPublisher = new LottoPublisher();
        List<Lotto> lottos = lottoPublisher.publishLotto(purchaseAmount);
        return lottos;
    }

    public void compareLotto() {

    }
}
