package test4.mockito.verfiy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.List;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith(MockitoJUnitRunner.class)
public class CompanyTest {

    @Mock
    Developer developer;

    @Mock
    List<Company> companies;

    @Test
    public void givenInputData_whenupdateDeveloper_thenUpdate() {
        // GIVEN

        Company company = new Company();

        // WHEN
        company.updateDeveloper(developer);

        // THEN
        verify(developer, times(1)).setName(anyString());
        verify(developer, times(1)).setLastName(anyString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNoData_whenupdateDeveloper_thenNotUpdate() {
        // GIVEN
        Company company = new Company();

        // WHEN
        company.updateDeveloper(null);

        // THEN
        verify(developer, never()).setName(anyString());
        verify(developer, never()).setLastName(anyString());
    }

    @Test
    public void givenInputData_whenupdateDeveloper_thenDoNothing() {
        // GIVEN
        Company company = new Company();

        // WHEN
        company.registerNewDeveloper(null);

        // THEN
        verifyZeroInteractions(developer);
    }
}
