package com.KG.KGMS.classRoom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClassRoomService {
    private final ClassRoomRepository classRoomRepository;

    @Autowired
    public ClassRoomService(ClassRoomRepository classRoomRepository) {
        this.classRoomRepository = classRoomRepository;
    }

    public List<ClassRoom> getAllClassRooms() {
        return classRoomRepository.findAll();
    }

    public ClassRoom getClassRoomById(Long id) {
        return classRoomRepository.findById(id).orElse(null);
    }

    public ClassRoom createClassRoom(ClassRoom classRoom) {
        return classRoomRepository.save(classRoom);
    }

    public ClassRoom updateClassRoom(ClassRoom classRoom) {
        return classRoomRepository.save(classRoom);
    }

    public void deleteClassRoom(Long id) {
        classRoomRepository.deleteById(id);
    }
}
