/**
 * 
 */
package com.consMang.transaction.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.consMang.transaction.product.model.ProductMasterModel;

/**
 * @author Vijay.Chauhan
 *
 */
public interface IProductDao {

	long createNew(ProductMasterModel productMasterModel) throws Exception;
	void updateProduct(ProductMasterModel productMasterModel) throws Exception;
	ProductMasterModel findProductById(Long productId) throws Exception;
	List<ProductMasterModel> getAllProduct(DetachedCriteria dt) throws Exception;
	void removeById(Long productId)throws Exception;
}
