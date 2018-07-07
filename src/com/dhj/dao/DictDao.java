package com.dhj.dao;

import java.util.List;

import com.dhj.domain.Dict;

public interface DictDao {

	List<Dict> findByCode(String dict_type_code);

}
