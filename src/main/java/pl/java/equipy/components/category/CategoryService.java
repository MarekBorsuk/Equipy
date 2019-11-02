package pl.java.equipy.components.category;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	private CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	List<String> findAllNames(){
		return categoryRepository.findAll()
				.stream()
				.map(Category::getName)
				.collect(Collectors.toList());		
	}
}
