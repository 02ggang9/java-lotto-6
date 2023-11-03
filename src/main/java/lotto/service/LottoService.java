package lotto.service;

import lotto.Lotto;
import lotto.LottoPublisher;
import lotto.LottoResult;
import lotto.repository.LottoRepository;

import java.util.List;

public class LottoService {

    private final LottoRepository lottoRepository = new LottoRepository();

    public LottoService() {
    }

    public List<Lotto> purchaseLotto(Long purchaseAmount) {
        LottoPublisher lottoPublisher = new LottoPublisher();
        List<Lotto> lottos = lottoPublisher.publishLotto(purchaseAmount);
        lottoRepository.saveAll(lottos);
        return lottos;
    }

    public void compareLotto(List<String> winningNumbers, Integer bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        List<Lotto> lottos = lottoRepository.findAll();
        lottoResult.showLottoResult(winningNumbers, bonusNumber, lottos);
    }
}
