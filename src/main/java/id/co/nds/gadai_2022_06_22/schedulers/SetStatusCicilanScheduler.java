package id.co.nds.gadai_2022_06_22.schedulers;

import java.util.Calendar;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import id.co.nds.gadai_2022_06_22.entities.CicilanEntity;
import id.co.nds.gadai_2022_06_22.services.TransactionService;

@Component
public class SetStatusCicilanScheduler {
    @Autowired
    private TransactionService transactionService;
    
    static final Logger logger = LogManager.getLogger(SetStatusCicilanScheduler.class);
    Integer counterB = 0;

    // @Scheduled(cron = "*/10 * * * * ?") //every 10 seconds
    public void cronSchedule() throws Exception {
        Integer counterA = 0;
        logger.debug("Start Cron at " + Calendar.getInstance().getTime());
        logger.info("Counter-A: " + counterA);
        logger.info("Counter-B: " + counterB);
        counterA++;
        counterB++;

        List<CicilanEntity> cicilan = transactionService.checkTransactionStatus();
        logger.info("Transaksi no." + counterB + ": " + cicilan.get(counterB).getNoTransaksi());
    }

}
