package com.esolutions.trainings.jsc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.fail;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class App {
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	private static final String CONTEXT = "http://localhost:9090";
	private static final int LOWER_LIMIT = 1900;
	private static final int UPPER_LIMIT = 2018;

	private static final Map<Integer, MatchModel> EXPECTED_REQ1;

	static {
		final MatchModel[] expected = {
				new MatchModel(1900, 60, "29-02-1900"),
				new MatchModel(1901, 140, "20-05-1901"),
				new MatchModel(1902, 323, "19-11-1902"),
				new MatchModel(1903, 256, "13-09-1903"),
				new MatchModel(1904, 121, "30-04-1904"),
				new MatchModel(1905, 45, "14-02-1905"),
				new MatchModel(1906, 2, "02-01-1906"),
				new MatchModel(1907, 27, "27-01-1907"),
				new MatchModel(1908, 341, "06-12-1908"),
				new MatchModel(1909, 18, "18-01-1909"),
				new MatchModel(1910, 160, "09-06-1910"),
				new MatchModel(1911, 170, "19-06-1911"),
				new MatchModel(1912, 83, "23-03-1912"),
				new MatchModel(1913, 178, "27-06-1913"),
				new MatchModel(1914, 67, "08-03-1914"),
				new MatchModel(1915, 69, "10-03-1915"),
				new MatchModel(1916, 222, "09-08-1916"),
				new MatchModel(1917, 301, "28-10-1917"),
				new MatchModel(1918, 13, "13-01-1918"),
				new MatchModel(1919, 29, "29-01-1919"),
				new MatchModel(1920, 10, "10-01-1920"),
				new MatchModel(1921, 221, "09-08-1921"),
				new MatchModel(1922, 14, "14-01-1922"),
				new MatchModel(1923, 87, "28-03-1923"),
				new MatchModel(1924, 99, "08-04-1924"),
				new MatchModel(1925, 45, "14-02-1925"),
				new MatchModel(1926, 100, "10-04-1926"),
				new MatchModel(1927, 363, "29-12-1927"),
				new MatchModel(1928, 212, "30-07-1928"),
				new MatchModel(1929, 15, "15-01-1929"),
				new MatchModel(1930, 16, "16-01-1930"),
				new MatchModel(1931, 13, "13-01-1931"),
				new MatchModel(1932, 67, "07-03-1932"),
				new MatchModel(1933, 227, "15-08-1933"),
				new MatchModel(1934, 260, "17-09-1934"),
				new MatchModel(1935, 92, "02-04-1935"),
				new MatchModel(1936, 102, "11-04-1936"),
				new MatchModel(1937, 199, "18-07-1937"),
				new MatchModel(1938, 97, "07-04-1938"),
				new MatchModel(1939, 96, "06-04-1939"),
				new MatchModel(1940, 146, "25-05-1940"),
				new MatchModel(1941, 59, "28-02-1941"),
				new MatchModel(1942, 139, "19-05-1942"),
				new MatchModel(1943, 145, "25-05-1943"),
				new MatchModel(1944, 1, "01-01-1944"),
				new MatchModel(1945, 350, "16-12-1945"),
				new MatchModel(1946, 136, "16-05-1946"),
				new MatchModel(1947, 118, "28-04-1947"),
				new MatchModel(1948, 4, "04-01-1948"),
				new MatchModel(1949, 76, "17-03-1949"),
				new MatchModel(1950, 40, "22-02-1950"),
				new MatchModel(1951, 309, "05-11-1951"),
				new MatchModel(1952, 324, "19-11-1952"),
				new MatchModel(1953, 155, "04-06-1953"),
				new MatchModel(1954, 233, "21-08-1954"),
				new MatchModel(1955, 18, "18-01-1955"),
				new MatchModel(1956, 175, "23-06-1956"),
				new MatchModel(1957, 62, "03-03-1957"),
				new MatchModel(1958, 59, "28-02-1958"),
				new MatchModel(1959, 214, "02-08-1959"),
				new MatchModel(1960, 366, "31-12-1960"),
				new MatchModel(1961, 104, "14-04-1961"),
				new MatchModel(1962, 364, "30-12-1962"),
				new MatchModel(1963, 106, "16-04-1963"),
				new MatchModel(1964, 208, "26-07-1964"),
				new MatchModel(1965, 219, "07-08-1965"),
				new MatchModel(1966, 251, "08-09-1966"),
				new MatchModel(1967, 286, "13-10-1967"),
				new MatchModel(1968, 165, "13-06-1968"),
				new MatchModel(1969, 222, "10-08-1969"),
				new MatchModel(1970, 129, "09-05-1970"),
				new MatchModel(1971, 34, "03-02-1971"),
				new MatchModel(1972, 253, "09-09-1972"),
				new MatchModel(1973, 358, "24-12-1973"),
				new MatchModel(1974, 186, "05-07-1974"),
				new MatchModel(1975, 1, "01-01-1975"),
				new MatchModel(1976, 73, "13-03-1976"),
				new MatchModel(1977, 298, "25-10-1977"),
				new MatchModel(1978, 87, "28-03-1978"),
				new MatchModel(1979, 230, "18-08-1979"),
				new MatchModel(1980, 194, "12-07-1980"),
				new MatchModel(1981, 233, "21-08-1981"),
				new MatchModel(1982, 311, "07-11-1982"),
				new MatchModel(1983, 162, "11-06-1983"),
				new MatchModel(1984, 53, "22-02-1984"),
				new MatchModel(1985, 203, "22-07-1985"),
				new MatchModel(1986, 40, "09-02-1986"),
				new MatchModel(1987, 94, "04-04-1987"),
				new MatchModel(1988, 51, "20-02-1988"),
				new MatchModel(1989, 45, "14-02-1989"),
				new MatchModel(1990, 359, "25-12-1990"),
				new MatchModel(1991, 254, "11-09-1991"),
				new MatchModel(1992, 135, "14-05-1992"),
				new MatchModel(1993, 226, "14-08-1993"),
				new MatchModel(1994, 216, "04-08-1994"),
				new MatchModel(1995, 104, "14-04-1995"),
				new MatchModel(1996, 51, "20-02-1996"),
				new MatchModel(1997, 12, "12-01-1997"),
				new MatchModel(1998, 212, "31-07-1998"),
				new MatchModel(1999, 327, "23-11-1999"),
				new MatchModel(2000, 266, "22-09-2000"),
				new MatchModel(2001, 193, "12-07-2001"),
				new MatchModel(2002, 17, "17-01-2002"),
				new MatchModel(2003, 365, "31-12-2003"),
				new MatchModel(2004, 299, "25-10-2004"),
				new MatchModel(2005, 81, "22-03-2005"),
				new MatchModel(2006, 59, "28-02-2006"),
				new MatchModel(2007, 262, "19-09-2007"),
				new MatchModel(2008, 19, "19-01-2008"),
				new MatchModel(2009, 111, "21-04-2009"),
				new MatchModel(2010, 121, "01-05-2010"),
				new MatchModel(2011, 103, "13-04-2011"),
				new MatchModel(2012, 35, "04-02-2012"),
				new MatchModel(2013, 169, "18-06-2013"),
				new MatchModel(2014, 198, "17-07-2014"),
				new MatchModel(2015, 49, "18-02-2015"),
				new MatchModel(2016, 241, "28-08-2016"),
				new MatchModel(2017, 210, "29-07-2017"),
				new MatchModel(2018, 187, "06-07-2018")
		};

		EXPECTED_REQ1 = Arrays
				.stream(expected)
				.collect(Collectors.toMap(MatchModel::getYear, Function.identity()));

	}

	private static final List<String> EXPECTED_REQ2;

	static {
		EXPECTED_REQ2 = new ArrayList<>();
		EXPECTED_REQ2.add("acosta");
		EXPECTED_REQ2.add("aguilar");
		EXPECTED_REQ2.add("alarcón");
		EXPECTED_REQ2.add("camarena");
		EXPECTED_REQ2.add("gaspar");
		EXPECTED_REQ2.add("gastan");
		EXPECTED_REQ2.add("morelos");
		EXPECTED_REQ2.add("pedrosa");
		EXPECTED_REQ2.add("teyo");
		EXPECTED_REQ2.add("álvarez");
	}

	private static final RankingModel EXPECTED_REQ3;

	static {
		EXPECTED_REQ3 =  new RankingModel();

		List<PlayerModel> playersAmerica = new ArrayList<>();
		playersAmerica.add(PlayerModel.build("camino,óscar", 7L));
		playersAmerica.add(PlayerModel.build("garia,alberto", 7L));
		playersAmerica.add(PlayerModel.build("pecina,tomas", 7L));
		playersAmerica.add(PlayerModel.build("Sandy, Adas", 6L));
		playersAmerica.add(PlayerModel.build("acosta,matias", 6L));
		playersAmerica.add(PlayerModel.build("aguilar,dorantes", 6L));
		playersAmerica.add(PlayerModel.build("camarena,dorantes", 6L));
		playersAmerica.add(PlayerModel.build("campa,óscar", 6L));
		playersAmerica.add(PlayerModel.build("pedraza,tomas", 6L));
		playersAmerica.add(PlayerModel.build("villanueba,gabriel", 6L));

		List<PlayerModel> playersEuropa = new ArrayList<>();
		playersEuropa.add(PlayerModel.build("campos,javier", 7L));
		playersEuropa.add(PlayerModel.build("morales,óscar", 7L));
		playersEuropa.add(PlayerModel.build("texeda,rodrigo", 7L));
		playersEuropa.add(PlayerModel.build("villalvazo,salvador", 7L));
		playersEuropa.add(PlayerModel.build("villanueba,gabriel", 7L));
		playersEuropa.add(PlayerModel.build("Bairn, Roberyl", 6L));
		playersEuropa.add(PlayerModel.build("camino,óscar", 6L));
		playersEuropa.add(PlayerModel.build("gascon,raúl", 6L));
		playersEuropa.add(PlayerModel.build("pavon,tomas", 6L));
		playersEuropa.add(PlayerModel.build("villalva,santiago", 6L));

		TeamModel teamAmerica = new TeamModel();
		TeamModel teamEuropa = new TeamModel();
		teamAmerica.setPlayers(playersAmerica);
		teamEuropa.setPlayers(playersEuropa);

		EXPECTED_REQ3.setEstrellas_de_america(teamAmerica);
		EXPECTED_REQ3.setEstrellas_de_europa(teamEuropa);
	}


	private RestTemplate restTemplate;

	@Before
	public void setUp() {
		restTemplate = new RestTemplate();
	}

	private static String urlReq1(int year) {
		return urlReq1(String.valueOf(year));
	}

	private static String urlReq1(String year) {
		return CONTEXT.concat("/matches/").concat(year);
	}

	private static String urlReq2() {
		return CONTEXT.concat("/players/last-name/repeated");
	}

	private static String urlReq3() {
		return CONTEXT.concat("/players/ranking");
	}

	@Test
	public void req_1() {
		final List<MatchModel> wrongAnswers = wrongAnswersWithLimits(1930, UPPER_LIMIT);

		if (!wrongAnswers.isEmpty()) {
			fail();
		}
	}

	@Test
	public void req_2() {
		final RepeatedLastNameModel response = this.restTemplate.getForObject(urlReq2(), RepeatedLastNameModel.class);

		final List<String> actualResponse = response.getLastNames1() != null ? response.getLastNames1() : response.getLastNames2();

		boolean pass = true;
		for (String actual : actualResponse) {
			if (!EXPECTED_REQ2.contains(actual)) {
				LOGGER.warn("Actual '{}' is not repeated", actual);
				pass = false;
			}
		}

		for (String expected : EXPECTED_REQ2) {
			if (!actualResponse.contains(expected)) {
				LOGGER.warn("Expected '{}' is not in response", expected);
				pass = false;
			}
		}

		if (!pass) {
			fail();
		}
	}

	@Test
	public void req_3() {
		final RankingModel response = this.restTemplate.getForObject(urlReq3(), RankingModel.class);

		boolean pass = true;

		for (int i = 0; i < response.getEstrellas_de_america().getPlayers().size(); i++) {
			PlayerModel expected = EXPECTED_REQ3.getEstrellas_de_america().getPlayers().get(i);
			PlayerModel actual = response.getEstrellas_de_america().getPlayers().get(i);
			if (!(expected.getName().equals(actual.getName()) && expected.getPlayed().equals(actual.getPlayed()))) {
				LOGGER.warn("Actual: {} does not match expected: {}", getRankedPlayer(actual), getRankedPlayer(expected));
				pass = false;
			}
		}

		for (int i = 0; i < response.getEstrellas_de_europa().getPlayers().size(); i++) {
			PlayerModel expected = EXPECTED_REQ3.getEstrellas_de_europa().getPlayers().get(i);
			PlayerModel actual = response.getEstrellas_de_europa().getPlayers().get(i);
			if (!(expected.getName().equals(actual.getName()) && expected.getPlayed().equals(actual.getPlayed()))) {
				LOGGER.warn("Actual: {} does not match expected: {}", getRankedPlayer(actual), getRankedPlayer(expected));
				pass = false;
			}
		}

		if (!pass) {
			fail();
		}

	}

	private String getRankedPlayer(PlayerModel model) {
		String message = "{name: %s, played: %s }";
		return message.format(message, model.getName(), model.getPlayed());
	}

	@Test
	public void req_4() {
		final List<MatchModel> wrongAnswers = wrongAnswersWithLimits(LOWER_LIMIT, UPPER_LIMIT);

		if (!wrongAnswers.isEmpty()) {
			fail();
		}
	}

	private List<MatchModel> wrongAnswersWithLimits(int from, int to) {
		return IntStream
				.range(from, to + 1)
				.mapToObj(year -> this.restTemplate.getForObject(urlReq1(year), MatchModel.class))
				.filter(match -> !match.equals(EXPECTED_REQ1.get(match.getYear())))
				.peek(match -> LOGGER.warn("Actual: {} does not match expected: {}", match, EXPECTED_REQ1.get(match.getYear())))
				.collect(Collectors.toList());
	}
}
