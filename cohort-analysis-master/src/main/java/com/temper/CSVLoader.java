package com.temper;

import java.io.FileReader;
import java.io.Reader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.temper.models.User;

@Component
public class CSVLoader {

    // private final static Logger logger = LogManager.getLogger(GenericResultProcessor.class.getName());
    Log log = LogFactory.getLog(getClass());

    // @Resource(name = "export.csv")
    // private File csv;

    String[] HEADERS = { "user_id", "created_at", "onboarding_perentage", "count_applications", "count_accepted_applications" };

    ArrayList<User> list;

    @Value(value = "classpath:data/export.csv")
    org.springframework.core.io.Resource csv;

    public List<User> loadDataFromFile() {
        try {

            if (list != null) {
                return list;
            }
            list = new ArrayList<>();

            Reader in = new FileReader(csv.getFile());
            Iterable<CSVRecord> records = CSVFormat.EXCEL.withDelimiter(';').withFirstRecordAsHeader().parse(in);// .withHeader(HEADERS)
            int a = 0;
            for (CSVRecord record : records) {
                User user = new User();
                a++;
                log.info(a);
                String id = record.get("user_id");
                if (id == null) {// skip row
                    continue;
                }
                user.id = Long.valueOf(id);

                String created = record.get("created_at");
                created = created == null ? "" : created.trim();
                user.created = created.length() < 1 ? null : Date.valueOf(created);

                String onboardingPercentage = record.get("onboarding_perentage");
                onboardingPercentage = onboardingPercentage == null ? "" : onboardingPercentage.trim();
                user.onboardingPercentage = onboardingPercentage.length() < 1 ? 0 : Double.valueOf(onboardingPercentage);

                String applications = record.get("count_applications");
                applications = applications == null ? "" : applications.trim();
                user.applications = applications.length() < 1 ? 0 : Integer.parseInt(applications);

                String acceptedApplications = record.get("count_accepted_applications");
                acceptedApplications = acceptedApplications == null ? "" : applications.trim();
                user.acceptedApplications = acceptedApplications.length() < 1 ? 0 : Integer.parseInt(acceptedApplications);

                log.info(user);

                list.add(user);

            }
            return list;
        } catch (Exception e) {
            log.error("Error occurred while loading object list from file " + csv, e);
            return new ArrayList<User>();// Collections.emptyList();
        }
    }

}
