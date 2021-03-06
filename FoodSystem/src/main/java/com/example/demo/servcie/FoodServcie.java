package com.example.demo.servcie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FoodMapper;
import com.example.demo.dao.FoodTypeMapper;
import com.example.demo.entity.Food;
import com.example.demo.entity.FoodExample;
import com.example.demo.entity.FoodType;
import com.example.demo.entity.FoodTypeExample;
import com.example.demo.entity.FoodTypeExample.Criteria;
import com.example.demo.until.StringUntil;


@Service
public class FoodServcie {
	
	@Autowired
	private FoodMapper foodDao;
	
	@Autowired
	private FoodTypeMapper foodTypeDao;
	
	
	
	public void addFood(Food f){
		foodDao.insert(f);
	}
	
	public List<Food> selectFoodByCondition(String str){
		List<Food> lists=new ArrayList<>();
		//是否为空
		if(str==null||"".equals(str)){
			//System.out.println("为空");
			lists = foodDao.selectByExample(null);
			return lists;
		}else{
			//System.out.println("不为空");
			//不为空
			//如果为数字，即为food的Id
			if(StringUntil.StringOrNumber(str)){
				//System.out.println("为数字");
				int number=Integer.parseInt(str);
				Food food=foodDao.selectByPrimaryKey(number);
				if(food!=null){
					lists.add(food);
				}
				return lists;
			}else{
				//System.out.println("不为数字，即为菜系或者菜名");
				//输入的为字符串，可能为菜系，也可能为菜名
				
				//如果为菜系名
				FoodTypeExample ftExample=new FoodTypeExample();
				Criteria ftc=ftExample.createCriteria();
				ftc.andTypenameEqualTo(str);
				
				List<FoodType> foodTypes=new ArrayList<>();
				foodTypes =	foodTypeDao.selectByExample(ftExample);
				//如果匹配的菜系
				Integer foodTypeId=null;
				if(foodTypes!=null&&foodTypes.size()>0){
					//System.out.println("为菜系");
					foodTypeId=foodTypes.get(0).getId();
					FoodExample fExampe=new FoodExample();
					fExampe.createCriteria().andFtypeEqualTo(foodTypeId);
					lists=foodDao.selectByExample(fExampe);
					return lists;

				}else{
					//System.out.println("为菜名");
					//如果匹配菜名
					FoodExample fExampe=new FoodExample();
					fExampe.createCriteria().andFnameLike("%"+str+"%");
					lists=foodDao.selectByExample(fExampe);
					return lists;
				}
				
				
				
				
			}
		}
		
		
		
	}
	
	
	public List<Food> selectAllFood(){
		List<Food> foods=foodDao.selectByExample(null);
		return foods;
	}
	
	public void deleteFood(int id){
		foodDao.deleteByPrimaryKey(id);
	}
	
	
	public Food selectFoodById(int id){
		return foodDao.selectByPrimaryKey(id);
	}
	
	
	public void updateFood(Food f){
		foodDao.updateByPrimaryKey(f);
	}
	
	

}
