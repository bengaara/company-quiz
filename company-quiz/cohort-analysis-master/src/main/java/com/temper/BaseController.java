package com.temper;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.temper.services.AnalysisService;

//@RestController
//@Controller
public class BaseController {

    @Autowired
    public AnalysisService analysisService;

    public Log log = LogFactory.getLog(getClass());

    @ExceptionHandler({ Exception.class })
    public @ResponseBody ResponseEntity handleError(HttpServletRequest req, Exception ex) {
        log.error("Request: " + req.getRequestURL() + " raised " + ex, ex);

        // org.json.JSONObject response = new org.json.JSONObject();

        // response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        // response.put("message", "unexpected error");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();// body();
    }
}
