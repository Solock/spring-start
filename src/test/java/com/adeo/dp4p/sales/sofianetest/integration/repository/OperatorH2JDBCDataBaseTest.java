package com.adeo.dp4p.sales.sofianetest.integration.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import com.adeo.dp4p.sales.sofianetest.exception.ObjectValueNullException;
import com.adeo.dp4p.sales.sofianetest.repository.OperatorH2JDBCDataBaseAdapter;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

public class OperatorH2JDBCDataBaseTest {

    @Mock
    private NamedParameterJdbcOperations mockJdbcOperations;

    @Captor
    private ArgumentCaptor<Map<String, Object>> mapCaptor;

    private OperatorH2JDBCDataBaseAdapter operatorH2JDBCDataBase;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        operatorH2JDBCDataBase = new OperatorH2JDBCDataBaseAdapter(mockJdbcOperations);
    }

    @Test
    public void testSaveInDataBase() throws ObjectValueNullException {
        BigDecimal result = new BigDecimal(42);
        Date date = new Date();
        String operator = "addition";

        when(mockJdbcOperations.update(anyString(), anyMap())).thenReturn(1);


        operatorH2JDBCDataBase.saveInDataBase(result, date, operator);

        verify(mockJdbcOperations).update(OperatorH2JDBCDataBaseAdapter.CREATE_VALUE_OPERATOR, mapCaptor.capture());
        Map<String, Object> capturedMap = mapCaptor.getValue();
        assertEquals(result, capturedMap.get("operator_result"));
        assertEquals(date, capturedMap.get("operator_date"));
        assertEquals(operator, capturedMap.get("operator_operator"));

    }
}