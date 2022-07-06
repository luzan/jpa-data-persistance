package edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.service.impl;

import edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.repository.TranscriptRepository;
import edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.service.TranscriptService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TranscriptServiceImpl implements TranscriptService {

    private final TranscriptRepository transcriptRepository;

    public TranscriptServiceImpl(TranscriptRepository transcriptRepository) {
        this.transcriptRepository = transcriptRepository;
    }

    @Override
    public void saveTranscript(Transcript transcript) {
        transcriptRepository.save(transcript);
    }
}
