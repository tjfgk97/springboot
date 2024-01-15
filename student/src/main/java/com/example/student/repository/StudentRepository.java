package com.example.student.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.student.dto.StudentDTO;

@Repository
public class StudentRepository {
	@Autowired
	private SqlSessionTemplate sql;

	public void save(StudentDTO studentDTO) {
		sql.insert("Student.save", studentDTO);
		// Student -> mapper의 namespace와 정확히 일치해야한다.
		// save -> mapper 쿼리문의 id와 일치해야한다.
		// studentDTO -> mapper의 parameterType과 일치해야한다.(String일 경우에는 String이라고 기재.
		// 여기서는 studentDTO이기 때문에 DTO 파일의 경로를 기재해주면 됨)
	}

	public List<StudentDTO> findAll() {
		return sql.selectList("Student.findAll");
	}

	public StudentDTO findById(Long id) {
		return sql.selectOne("Student.findById", id);
	}

}
