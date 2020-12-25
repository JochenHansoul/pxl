CREATE OR REPLACE TRIGGER biuds_jobs
BEFORE INSERT OR UPDATE OR DELETE
ON jobs
DECLARE
	v_adjust VARCHAR2(3);
BEGIN
	IF USER = 'student' OR USER = 'bezoeker' THEN
		RAISE_APPLICATION_ERROR(-20000, 'Je hebt onvoldoende rechten om deze actie uit te voeren!');
	--ELSE
		--ACCEPT v_adjust PROMPT 'Ben je zeker dat je het minimum en/of maximum salaris van één of meerdere jobs wil aanpassen?';
		--IF v_adjust == 'n' OR v_adjust == 'no' THEN
			--ROLLBACK;
		--END IF;
	END IF;
END;
/
