package com.KG.KGMS.classRoom;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {
    // Additional custom queries can be added here if needed
}