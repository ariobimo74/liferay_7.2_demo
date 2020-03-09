package transaction.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import transaction.model.Transaction;
import transaction.service.TransactionLocalService;
import transaction.service.persistence.TransactionFinder;

import java.util.List;

public class TransactionFinderImpl extends TransactionFinderBaseImpl implements TransactionFinder
{
    private TransactionLocalService transactionLocalService;

    public List<Transaction> findTransactionById(int theId)
    {
        Session session = null;

        try
        {
            session = openSession();

            ClassLoader classLoader = getClass().getClassLoader();

            DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Transaction.class, classLoader)
                    .add(RestrictionsFactoryUtil.eq("id", theId))
                    .setProjection(ProjectionFactoryUtil.property("id"));

            Order order = OrderFactoryUtil.asc("transactionDate");

            List<Transaction> transactionList = transactionLocalService.dynamicQuery(dynamicQuery);

            return transactionList;
        }
        catch (Exception e)
        {
            try
            {
                throw new SystemException(e);
            }
            catch (SystemException se)
            {
                se.printStackTrace();
            }
        }
        finally
        {
            closeSession(session);
        }

        return null;
    }
}
