package com.koikeya.project1.domain.service;

import com.koikeya.project1.domain.model.MailForm;

public interface SendMailService {

    public void send(MailForm mailForm);
}
