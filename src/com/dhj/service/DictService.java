package com.dhj.service;

import java.util.List;

import com.dhj.domain.Dict;

public interface DictService {

	List<Dict> findByCode(String dict_type_code);

}
