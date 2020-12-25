SELECT		DISTINCT p.theatre_performance, TO_CHAR(ra.date_starttime, 'DD-MM-yyy HH:mm'), a.actor_firstname, a.actor_name
FROM		performances p
JOIN		performance_dates pd	ON	(p.season  = pd.season)
JOIN		performance_actors pa	ON	(p.theatre_performance = pa.theatre_performance)
JOIN		actors a				ON	(pa.actor_id = a.actor_id)
JOIN		rehearsal_actors ra		ON	(pa.actor_id = ra.actor_id)
ORDER BY	p.theatre_performance
/
