package id.co.nds.gadai_2022_06_22.schedulers;

import java.util.Calendar;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import id.co.nds.gadai_2022_06_22.entities.CicilanEntity;
import id.co.nds.gadai_2022_06_22.services.TrxService;


@Component
public class CronScheduler {
    static final Logger logger = LogManager.getLogger(CronScheduler.class);

    @Autowired
    TrxService trxService;

    Integer counterB = 0;

  @Scheduled(cron = "0 0 0 * * ?")
    public void cronScheduler() throws Exception{
        Integer counterA =0;
        logger.debug("Start FixedRateScheduller at " + Calendar.getInstance().getTime());
        logger.info("Counter-A: " + counterA);
        logger.info("Counter-A: " + counterA);
        counterA++;
        counterB++;

        List<CicilanEntity> cicilan = trxService.checkStatusCicilan();
        for (int i =0; i<cicilan.size(); i++){
          logger.info("Transaksi no-"+ counterB +": "+ cicilan.get(i).getNoTransaksi() + "status: " + cicilan.get(i).getStatusTrans());
      }
    
        
    }

    
}
