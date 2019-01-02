/**
 * 
 */
package com.consMang.transaction.product.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.consMang.common.dao.impl.GenericDAOImpl;
import com.consMang.transaction.product.dao.IProductDao;
import com.consMang.transaction.product.model.ProductMasterModel;

/**
 * @author Vijay.Chauhan
 *
 */
@Repository(value = "ProductDao")
public class ProductDaoImpl extends GenericDAOImpl<ProductMasterModel, Long> implements IProductDao {

	/* (non-Javadoc)
	 * @see com.consMang.transaction.product.dao.ProductDao#createNew(com.consMang.transaction.product.model.ProductMasterModel)
	 */
	@Override
	public long createNew(ProductMasterModel productMasterModel)throws Exception {
		// TODO Auto-generated method stub
		return super.createEntity(productMasterModel);
	}

	/* (non-Javadoc)
	 * @see com.consMang.transaction.product.dao.ProductDao#updateProduct(com.consMang.transaction.product.model.ProductMasterModel)
	 */
	@Override
	public void updateProduct(ProductMasterModel productMasterModel)throws Exception {
		// TODO Auto-generated method stub
		super.updateEntity(productMasterModel);
	}

	/* (non-Javadoc)
	 * @see com.consMang.transaction.product.dao.ProductDao#findProductById(java.lang.Long)
	 */
	@Override
	public ProductMasterModel findProductById(Long productId)throws Exception {
		// TODO Auto-generated method stub
		return super.findOne(productId);
	}

	/* (non-Javadoc)
	 * @see com.consMang.transaction.product.dao.ProductDao#getAllProduct()
	 */
	@Override
	public List<ProductMasterModel> getAllProduct(DetachedCriteria dt)throws Exception {
		// TODO Auto-generated method stub
		return super.getList(dt);
	}


	/* (non-Javadoc)
	 * @see com.consMang.transaction.product.dao.ProductDao#removeById(java.lang.Long)
	 */
	@Override
	public void removeById(Long productId) throws Exception {
		// TODO Auto-generated method stub
		super.deleteById(productId);
	}

}
