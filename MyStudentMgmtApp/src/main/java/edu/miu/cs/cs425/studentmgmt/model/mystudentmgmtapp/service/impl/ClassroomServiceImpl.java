package edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.service.impl;

import edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.repository.ClassroomRepository;
import edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.service.ClassroomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    private final ClassroomRepository classroomRepository;

    public ClassroomServiceImpl(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @Override
    public void saveClassroom(Classroom classroom) {
        classroomRepository.save(classroom);
    }
}
