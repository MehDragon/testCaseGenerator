package com.example.testcase.controller;

import com.example.testcase.service.Docx;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
public class DocController {

    final
    Docx docx;

    public DocController(Docx docx) {
        this.docx = docx;
    }

    @RequestMapping(value = "/word", method = RequestMethod.POST,
            produces="application/vnd.openxmlformats-officedocument.wordprocessingml.document")
    public @ResponseBody byte[] convertToDoc(@RequestParam(defaultValue = "<p> </p>") String text,
                                             @RequestParam(defaultValue = "14") int fontSize) {
        return docx.fromString(text, fontSize);
    }
}
