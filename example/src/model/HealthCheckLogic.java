package model;

public class HealthCheckLogic {
	/*
	 * bmiを計算して体型を求める
	 * @param health 
	 */
	public void excute(Health health) {
		final double height = health.getHeight() / 100.0;
		final double weight = health.getWeight();
		final double bmi = weight / (height * height);
		
		// 体型を算出します
		final String bodyType;
		if(bmi < 18.5) {
			bodyType = "痩せ型";
		} else if(bmi < 25.0) {
			bodyType = "普通";
		} else {
			bodyType = "肥満";
		}
		
		health.setBmi(bmi);
		health.setBodyType(bodyType);
	}
}
