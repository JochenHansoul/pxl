CREATE OR REPLACE TRIGGER buids_employees
BEFORE INSERT OR UPDATE OR DELETE
ON employees
DECLARE
	v_day VARCHAR2(1);
BEGIN
	IF UPDATING OR DELETING THEN
		v_day := TO_CHAR(sysdate,'fmD');
		IF v_day = '1' OR v_day = '7' THEN
			RAISE_APPLICATION_ERROR(-20000, 'U kunt geen employees toevoegen of verwijderen in het weekend');
		END IF;
	END IF;
END;
/