/**
 * 
 */
package com.consMang.transaction.product.service.impl;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.consMang.transaction.product.dao.IProductDao;
import com.consMang.transaction.product.model.ProductMasterModel;
import com.consMang.transaction.product.service.IProductService;

/**
 * @author Vijay.Chauhan
 *
 */

@Service(value="productService")
@Scope("request")
public class ProductServiceImpl implements IProductService {

	private static final Logger LOGGER = Logger.getLogger(ProductServiceImpl.class);
	
	@Autowired
	IProductDao productDAO;
	

	/* (non-Javadoc)
	 * @see com.consMang.transaction.product.service.IProductService#createNew(com.consMang.transaction.product.model.ProductMasterModel)
	 */
	@Override
	public long createNew(ProductMasterModel productMasterModel)
			throws Exception {
		// TODO Auto-generated method stub
		productMasterModel.setCreatedOn(Calendar.getInstance());
		return productDAO.createNew(productMasterModel);
	}

	/* (non-Javadoc)
	 * @see com.consMang.transaction.product.service.IProductService#updateProduct(com.consMang.transaction.product.model.ProductMasterModel)
	 */
	@Override
	public void updateProduct(ProductMasterModel productMasterModel)
			throws Exception {
		// TODO Auto-generated method stub
		productMasterModel.setModifiedOn(Calendar.getInstance());
		productDAO.updateProduct(productMasterModel);

	}

	/* (non-Javadoc)
	 * @see com.consMang.transaction.product.service.IProductService#findProductById(java.lang.Long)
	 */
	@Override
	public ProductMasterModel findProductById(Long productId) throws Exception {
		return productDAO.findProductById(productId);
	}

	/* (non-Javadoc)
	 * @see com.consMang.transaction.product.service.IProductService#getAllProduct()
	 */
	@Override
	public List<ProductMasterModel> getAllProduct() throws Exception {
		DetachedCriteria dt=DetachedCriteria.forClass(ProductMasterModel.class);
		return productDAO.getAllProduct(dt);
	}

	/* (non-Javadoc)
	 * @see com.consMang.transaction.product.service.IProductService#removeById(java.lang.Long)
	 */
	@Override
	public void removeById(Long productId) throws Exception {
		productDAO.removeById(productId);
	}

}
