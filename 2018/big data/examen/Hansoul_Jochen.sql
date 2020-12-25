CREATE OR REPLACE PROCEDURE get_performances
	(p_month	NUMBER
	,p_year		NUMBER)
AS
	v_name_performance	performances.theatre_performance%TYPE;
	v_date_and_time		VARCHAR2(16);
	v_firstname			actors.actor_firstname%TYPE;
	v_name				actors.actor_name%TYPE;
BEGIN
	FOR rec IN (
		SELECT		DISTINCT p.theatre_performance, TO_CHAR(ra.date_starttime, 'DD-MM-yyyy HH:mm') --, COUNT(a.actor_firstname)
		INTO		v_name_performance, v_date_and_time
		FROM		performances p
		JOIN		performance_dates pd	ON	(p.season  = pd.season)
		JOIN		performance_actors pa	ON	(p.theatre_performance = pa.theatre_performance)
		JOIN		rehearsal_actors ra		ON	(pa.actor_id = ra.actor_id)
		WHERE		TO_CHAR(pd.date_time, 'FMyyyy') = p_year AND TO_CHAR(pd.date_time, 'FMMM') = p_month
		ORDER BY	p.theatre_performance)
		LOOP
		DBMS_OUTPUT.PUT_LINE(v_name_performance || ' ' || v_date_and_time);

		SELECT		a.actor_firstname, a.actor_name
		INTO		v_firstname, v_name
		FROM		performances p
		JOIN		performance_dates pd	ON	(p.season  = pd.season)
		JOIN		performance_actors pa	ON	(p.theatre_performance = pa.theatre_performance)
		JOIN		actors a				ON	(pa.actor_id = a.actor_id)
		JOIN		rehearsal_actors ra		ON	(pa.actor_id = ra.actor_id)
		WHERE		TO_CHAR(pd.date_time, 'FMyyyy') = p_year AND TO_CHAR(pd.date_time, 'FMMM') = p_month AND p.theatre_performance = rec.theatre_performance
		ORDER BY	p.theatre_performance;
		DBMS_OUTPUT.PUT_LINE('--> ' || v_name || ' ' || v_firstname);
		/*
		FOR rec2 IN (
			SELECT		DISTINCT p.theatre_performance, TO_CHAR(ra.date_starttime, 'DD-MM-yyyy HH:mm'), a.actor_firstname, a.actor_name
			INTO		v_name_performance, v_date_and_time, v_firstname, v_name
			FROM		performances p
			JOIN		performance_dates pd	ON	(p.season  = pd.season)
			JOIN		performance_actors pa	ON	(p.theatre_performance = pa.theatre_performance)
			JOIN		actors a				ON	(pa.actor_id = a.actor_id)
			JOIN		rehearsal_actors ra		ON	(pa.actor_id = ra.actor_id)
			WHERE		p.theatre_performance = rec.theatre_performance
			ORDER BY	p.theatre_performance
			)
			LOOP
			DBMS_OUTPUT.PUT_LINE('--> ' || v_name || ' ' || v_firstname);
		END LOOP;
		*/
	END LOOP;
END;
/
