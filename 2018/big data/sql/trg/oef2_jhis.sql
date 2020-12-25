CREATE OR REPLACE TRIGGER auids_jhis
AFTER UPDATE OR INSERT OR DELETE
ON job_history
DECLARE
	v_log_actie VARCHAR2(15);
BEGIN
	IF updating THEN
		v_log_actie := 'UPDATE';
	ELSIF inserting THEN
		v_log_actie := 'INSERT';
	ELSE
		v_log_actie := 'DELETE';
	END IF;
	INSERT INTO log_history
	VALUES(user, sysdate, systimestamp, v_log_actie); --eerst tabel log_history aanmaken!
END;
/